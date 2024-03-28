const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component{
    constructor(props) {
        super(props);
        this.state = {webUsers: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/webUsers'}).done(response => {
            this.setState({ webUsers: response.entity._embedded.webUsers});
        });
    }
    render() {
        return (
            <WebUserList webUsers={this.state.webUsers}/>
        )
    }
}

class EmployeeList extends React.Component{
    render() {
        const webUsers = this.props.webUsers.map(webUser => <WebUser key={webUser._links.self.href} webUser={webUser}/>);
        return (
            <table>
                <tbody>
                    <tr>
                        <th>User Name</th>
                        <th>Password</th>
                    </tr>
                    {webUsers}
                </tbody>
            </table>
        )
    }
}

class WebUser extends React.Component{
    render() {
        return(
            <tr>
                <td>{this.props.webUser.username}</td>
                <td>{this.props.webUser.password}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)