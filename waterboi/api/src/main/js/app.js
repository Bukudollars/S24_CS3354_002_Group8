import React from 'react';
import ViewPosts from './viewPosts.js';
import { Container, Grid, Box } from '@mui/material';
import { BottomNavigation, BottomNavigationAction } from '@mui/material';
import { Typography } from '@mui/material';
import HomeIcon from '@mui/icons-material/Home';
import FavoriteIcon from '@mui/icons-material/Favorite';
import SettingsIcon from '@mui/icons-material/Settings';
//import './app.css';
import Dashboard from './dashboard/dashboard.js';
function App() {
    return (
            <Dashboard />  
    );
}

export default App;