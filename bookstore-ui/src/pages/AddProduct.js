import React, { useState } from 'react';
import axios from 'axios';

const AddProduct = () => {
    const [form, setForm] = useState({ title: '', author: '', price: '' });

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const addBook = () => {
        axios.post('http://localhost:8080/books', form)
            .then(() => {
                alert('Book added successfully!');
                setForm({ title: '', author: '', price: '' });
            })
            .catch(err => console.error(err));
    };

    return (
        <div style={{ padding: '1rem' }}>
            <h2>Add a New Book</h2>
            <input
                name="title"
                placeholder="Title"
                value={form.title}
                onChange={handleChange}
            />

            <input
                name="author"
                placeholder="Author"
                value={form.author}
                onChange={handleChange}
            />
            <input
                name="price"
                placeholder="Price"
                type="number"
                value={form.price}
                onChange={handleChange}
            />
            <button onClick={addBook}>Add Book</button>
        </div>
    );
};

export default AddProduct;
