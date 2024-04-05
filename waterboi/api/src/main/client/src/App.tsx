
import Container from '@mui/material/Container';
// import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
// import Link from '@mui/material/Link';
import Dashboard from './dashboard/Dashboard';

// function Copyright() {
//   return (
//     <Typography variant="body2" color="text.secondary" align="center">
//       {'Copyright © '}
//       <Link color="inherit" href="https://mui.com/">
//         Your Website
//       </Link>{' '}
//       {new Date().getFullYear()}.
//     </Typography>
//   );
// }

export default function App() {
  return (
    <Container maxWidth="lg">
      <Box sx={{ my: 4 }}>
        <Dashboard />
      </Box>
    </Container>
  );
}