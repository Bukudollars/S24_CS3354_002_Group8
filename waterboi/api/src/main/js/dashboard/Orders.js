// import * as React from 'react';
import Link from '@mui/material/Link';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Title from './Title';
import React, { useState, useEffect } from 'react';

// Generate Order Data
function createData(id, date, name, shipTo, paymentMethod, amount) {
  return { id, date, name, shipTo, paymentMethod, amount };
}



const rows = [
  createData(
    0,
    '16 Mar, 2019',
    'Elvis Presley',
    'Tupelo, MS',
    'VISA ⠀•••• 3719',
    312.44,
  ),
  createData(
    1,
    '16 Mar, 2019',
    'Paul McCartney',
    'London, UK',
    'VISA ⠀•••• 2574',
    866.99,
  ),
  createData(2, '16 Mar, 2019', 'Tom Scholz', 'Boston, MA', 'MC ⠀•••• 1253', 100.81),
  createData(
    3,
    '16 Mar, 2019',
    'Michael Jackson',
    'Gary, IN',
    'AMEX ⠀•••• 2000',
    654.39,
  ),
  createData(
    4,
    '15 Mar, 2019',
    'Bruce Springsteen',
    'Long Branch, NJ',
    'VISA ⠀•••• 5919',
    212.79,
  ),
];


function preventDefault(event) {
  event.preventDefault();
}

export default function Orders() {
    const [posts, setPosts] = useState([]);
    const [units, setUnits] = useState({});

    useEffect(() => {
        fetch('/api/post/all')
        .then(response => response.json())
        .then(data => setPosts(data))
        .catch(error => console.error('Error fetching data:', error));
        // console.log(posts);

        fetch('/api/post/units')
        .then(response => response.json())
        .then(data => {
            const unitsMap = data.reduce((acc, unit) => {
                acc[unit.id] = {
                    name: unit.name,
                    literMultiple: unit.literMultiple
                }
                return acc;
            }, {});
            setUnits(unitsMap);
            // console.log(unitsMap);
        })
        .catch(error => console.error('Error fetching units:', error));
    }, []);

  return (
    <React.Fragment>
      <Title>Recent Drinks</Title>
      <Table size="small">
        <TableHead>
          <TableRow>
            <TableCell>Date</TableCell>
            <TableCell>Time</TableCell>
            <TableCell>Amount</TableCell>
            {/* <TableCell>Payment Method</TableCell>
            <TableCell align="right">Sale Amount</TableCell> */}
          </TableRow>
        </TableHead>
        <TableBody>
          {posts.map((post) => (
            <TableRow key={post.id}>
              <TableCell>{post.postTime}</TableCell>
              <TableCell>{post.postTime}</TableCell>
              <TableCell>{post.quantity}</TableCell>
              {/* <TableCell>{row.shipTo}</TableCell>
              <TableCell>{row.paymentMethod}</TableCell>
              <TableCell align="right">{`$${row.amount}`}</TableCell> */}
            </TableRow>
          ))}
        </TableBody>
      </Table>
      <Link color="primary" href="#" onClick={preventDefault} sx={{ mt: 3 }}>
        See more drinks
      </Link>
    </React.Fragment>
  );
}