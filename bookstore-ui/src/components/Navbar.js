import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
    return (
        <nav style={{
            padding: '1rem',
            backgroundColor: '#f0f0f0',
            marginBottom: '2rem'
        }}>
            <Link to="/" style={{ marginRight: '1rem' }}> Home</Link>
            <Link to="/add">➕ Add Product</Link>
        </nav>
    );
};

export default Navbar;
