import * as React from 'react';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
// import ListSubheader from '@mui/material/ListSubheader';

import LocalDrinkIcon from '@mui/icons-material/LocalDrink';
import AddBoxIcon from '@mui/icons-material/AddBox';
import ExitToAppIcon from '@mui/icons-material/ExitToApp';

import AssignmentIcon from '@mui/icons-material/Assignment';
import DonutLargeIcon from '@mui/icons-material/DonutLarge';
import PersonIcon from '@mui/icons-material/Person';
import { DashboardContext } from './DashboardContext';
import { useContext } from 'react';
import { Link } from 'react-router-dom';

export function MainListItems() {
    const { setCurrentView } = useContext(DashboardContext);
    return(
        <React.Fragment>
    <ListItemButton onClick={() => setCurrentView('progress')}>
      <ListItemIcon>
        <DonutLargeIcon />
      </ListItemIcon>
      <ListItemText primary="Progress" />
    </ListItemButton>
    <ListItemButton onClick={() => setCurrentView('drinks')}>
      <ListItemIcon>
        <LocalDrinkIcon />
      </ListItemIcon>
      <ListItemText primary="Drinks" />
    </ListItemButton>
    <ListItemButton onClick={() => setCurrentView('add-drink')}>
      <ListItemIcon>
        <AddBoxIcon />
      </ListItemIcon>
      <ListItemText primary="Add Drink" />
    </ListItemButton>
    <ListItemButton onClick={() => {
        setCurrentView('profile');
    }}>
      <ListItemIcon>
        <PersonIcon />
      </ListItemIcon>
      <ListItemText primary="Profile" />
    </ListItemButton>
    {/* <ListItemButton>
      <ListItemIcon>
        <BarChartIcon />
      </ListItemIcon>
      <ListItemText primary="Reports" />
    </ListItemButton>
    <ListItemButton>
      <ListItemIcon>
        <LayersIcon />
      </ListItemIcon>
      <ListItemText primary="Integrations" />
    </ListItemButton> */}
  </React.Fragment>
    );
  
}

export function SecondaryListItems() {

    return(
        <React.Fragment>
    {/* <ListSubheader component="div" inset>
      Saved reports
    </ListSubheader>
    <ListItemButton>
      <ListItemIcon>
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="This Week" />
    </ListItemButton>
    <ListItemButton>
      <ListItemIcon>
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="This Month" />
    </ListItemButton> */}
    <ListItemButton component={Link} to="/logout">
      <ListItemIcon>
        <ExitToAppIcon />
      </ListItemIcon>
      <ListItemText primary="Sign Out" />
    </ListItemButton>
  </React.Fragment>
    )
  
}