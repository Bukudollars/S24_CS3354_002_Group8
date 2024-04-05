import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SignIn from './SignIn.tsx';
import SignUp from './SignUp.tsx';
import { ThemeProvider } from '@emotion/react';
import { CssBaseline } from '@mui/material';
import theme from './theme';


ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Router>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/cake" element={<div style={{ fontSize: 150 }}>🍰</div>} />
        <Route path="/login" element={<SignIn />} />
        <Route path="/register" element={<SignUp />} />
      </Routes>
    </Router>
    </ThemeProvider>
    
  </React.StrictMode>,
)
