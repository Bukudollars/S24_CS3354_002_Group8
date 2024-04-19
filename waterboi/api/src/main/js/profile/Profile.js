import React, { useState, useEffect } from 'react';
import { Container, TextField, Button, Typography } from '@mui/material';

export default function Profile() {
  const [user, setUser] = useState({ id: '', dailyGoal: ''});
  useEffect(() => {
    fetch('/api/user/profile')
      .then(response => response.json())
      .then(data => setUser(data));
      console.log(user);
  }, []);

  const handleChange = (event) => {
    setUser({ ...user, [event.target.name]: event.target.value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    fetch('/api/user/profile/goal/day', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ goal: user.dailyGoal }),
    });
  };

  return (
    <Container sx={{maxWidth: 'sm'}}>
      <Typography variant="h4" align="center">User Profile</Typography>
      <form noValidate autoComplete="off" onSubmit={handleSubmit}>
        <TextField
          name="dailyGoal"
          label="Daily Goal"
          value={user.dailyGoal}
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
        <Button variant="contained" color="primary" fullWidth type="submit">
          Save
        </Button>
      </form>
    </Container>
  );
}
