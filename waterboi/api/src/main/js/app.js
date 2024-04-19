import React, { useEffect } from 'react';
import ViewPosts from './viewPosts.js';
import { Container, Grid, Box } from '@mui/material';
import { BottomNavigation, BottomNavigationAction } from '@mui/material';
import { Typography } from '@mui/material';
import HomeIcon from '@mui/icons-material/Home';
import FavoriteIcon from '@mui/icons-material/Favorite';
import SettingsIcon from '@mui/icons-material/Settings';
//import './app.css';
import Dashboard from './dashboard/dashboard.js';
import { BrowserRouter as Router, Route, useNavigate, Routes} from 'react-router-dom';

function Logout() {
    let navigate = useNavigate();
    useEffect(() => {
        fetch('/logout')
        .then(response => {
            if(response.ok) {
                window.location.href = '/login';
            }
        });
    });
    return null;
}
export default function App() {
    return (
        <Router>
            <Routes>
                <Route path="/logout" element={<Logout />} />
                <Route path="/home" element={<Dashboard />} />
            </Routes>
            
        </Router>
    );
}
