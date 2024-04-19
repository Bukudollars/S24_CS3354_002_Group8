import React, { useState, useEffect } from 'react';
import { Container, TextField, Button, Typography } from '@mui/material';

export default function Profile() {
  const [user, setUser] = useState({ id: '', dailyGoal: ''});
  useEffect(() => {
    fetch('/api/user/profile')
      .then(response => response.json())
      .then(data => setUser(data));
  }, []);

  const handleChange = (event) => {
    setUser({ ...user, [event.target.name]: event.target.value });
  };

  return (
    <Container sx={{maxWidth: 'sm'}}>
      <Typography variant="h4" align="center">User Profile</Typography>
      <form noValidate autoComplete="off">
        <TextField
          name="dailyGoal"
          label="Daily Goal"
          value={user.name}
          onChange={handleChange}
          fullWidth
          margin="normal"
        />
        {/* <TextField
          name="email"
          label="Email"
          value={user.email}
          onChange={handleChange}
          fullWidth
          margin="normal"
        /> */}
        {/* <TextField
          name="bio"
          label="Bio"
          value={user.bio}
          onChange={handleChange}
          fullWidth
          multiline
          rows={4}
          margin="normal"
        /> */}
        <Button variant="contained" color="primary" fullWidth>
          Save
        </Button>
      </form>
    </Container>
  );
}
