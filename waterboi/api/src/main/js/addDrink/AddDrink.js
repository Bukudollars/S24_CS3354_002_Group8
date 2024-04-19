import React, { useState, useEffect } from 'react';
import { Container, TextField, Button, Typography } from '@mui/material';
import styled from 'styled-components';

const Holder = styled.div`
  background-color: white;
  padding: 20px;
  font-family: Arial, sans-serif;
  text-align: center;
`;

const Title = styled.h1`
  color: black;
  margin-bottom: 20px;
`;

const Input = styled.input`
  padding: 10px;
  font-size: 16px;
  margin-bottom: 20px;
`;

const TabList = styled.div`
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
`;

const Tab = styled.button`
  background-color: ${props => (props.active ? 'black' : 'white')};
  color: ${props => (props.active ? 'white' : 'black')};
  border: 1px solid black;
  padding: 10px 20px;
  cursor: pointer;
  transition: background-color 0.3s ease, color 0.3s ease;

  &:not(:last-child) {
    margin-right: 10px;
  }
`;

const Question = styled.p`
  margin-bottom: 20px;
`;

const ButtonTwo = styled.button`
  background-color: blue;
  color: white;
  border: none;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
`;

const AddDrink = () => {
  const [value, setValue] = useState('2');
  const [activeTab, setActiveTab] = useState('Cups');

  const handleInputChange = (e) => {
    setValue(e.target.value);
  };

  const handleTabClick = (tab) => {
    setActiveTab(tab);
  };
  const handleSubmit = (event) => {
    fetch('/api/post/new', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ 
        quantity: value,
      unitId : 1 }),
    });
  };

  return (
    <Holder>
      <Title>Been Drinking?</Title>
      <Input
        type="text"
        value={value}
        onChange={handleInputChange}
      />
      <TabList>
        <Tab
          active={activeTab === 'Cups'}
          onClick={() => handleTabClick('Cups')}
        >
          Cups
        </Tab>
        <Tab
          active={activeTab === 'Liters'}
          onClick={() => handleTabClick('Liters')}
        >
          Liters
        </Tab>
        <Tab
          active={activeTab === 'Gallons'}
          onClick={() => handleTabClick('Gallons')}
        >
          Gallons
        </Tab>
      </TabList>
      <Question>Sure about that?</Question>
      <ButtonTwo onClick={handleSubmit} >I am Sure!</ButtonTwo>
    </Holder>
  );
};

export default AddDrink;