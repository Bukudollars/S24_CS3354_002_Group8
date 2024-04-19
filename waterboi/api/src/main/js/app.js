import React from 'react';
import ViewPosts from './viewPosts.js';
import { Container, Grid, Box } from '@mui/material';
import { BottomNavigation, BottomNavigationAction } from '@mui/material';
import { Typography } from '@mui/material';
import HomeIcon from '@mui/icons-material/Home';
import FavoriteIcon from '@mui/icons-material/Favorite';
import SettingsIcon from '@mui/icons-material/Settings';
import './app.css';
import Dashboard from './dashboard/dashboard.js';
function App() {
    return (
        // <Container>
        //     <Grid container spacing={3}>
        //         <Grid item xs={12}>
        //             <Box display="flex" justifyContent="center">
        //                 <Typography variant="h1" component="h2" gutterBottom className="page-title">
        //                     Water Tracker
        //                 </Typography>
        //             </Box>
                    
        //         </Grid>
        //         <Grid item xs={12}>
        //         {ViewPosts()}
        //         </Grid>
        //         <Grid item xs={12}>
        //             <BottomNavigation className='bottom-nav'>
        //                 <BottomNavigationAction label="Home" icon={<HomeIcon className='nav-icon' />} />
        //                 <BottomNavigationAction label="Favorites" icon={<FavoriteIcon className='nav-icon' />} />
        //                 <BottomNavigationAction label="Settings" icon={<SettingsIcon className='nav-icon' />} />
        //             </BottomNavigation>
        //         </Grid>
        //     </Grid> 
        // </Container>
        <Dashboard />

    );
}

export default App;