import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import HomePage from './pages/HomePage';
import AddProduct from './pages/AddProduct';

function App() {
  return (
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/add" element={<AddProduct />} />
        </Routes>
      </Router>
  );
}

export default App;
