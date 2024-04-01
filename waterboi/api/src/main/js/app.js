import React, { useState, useEffect } from 'react';
function App() {
    const [data, setData] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/post/all')
        .then(response => response.json())
        .then(data => setData(data))
        .catch(error => console.error('Error fetching data:', error));
    }, []);

    return (
        <div className="App">
            <table>
                <thead>
                    <tr>
                        <th>appuserId</th>
                        <th>quantity</th>
                        <th>unitOfMeasureId</th>
                        <th>postTime</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map(item => (
                        <tr key={item.id}>
                            <td>{item.appuserId}</td>
                            <td>{item.quantity}</td>
                            <td>{item.unitOfMeasureId}</td>
                            <td>{item.postTime}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}
export default App;