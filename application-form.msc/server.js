const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const app = express();

// Middleware
app.use(cors());
app.use(express.json());

// MongoDB connection
const MONGODB_URI = 'mongodb+srv://praveenramisetti_db_user:f0reCOPFdRLlihEr@msc.kmiogsu.mongodb.net/?retryWrites=true&w=majority&appName=msc';
mongoose.connect(MONGODB_URI)
  .then(() => console.log('Connected to MongoDB'))
  .catch(err => console.error('Could not connect to MongoDB:', err));

// Application Schema
const applicationSchema = new mongoose.Schema({
    name: { type: String, required: true },
    email: { type: String, required: true },
    phone: { type: String, required: true },
});

const Application = mongoose.model('Application', applicationSchema);

// POST endpoint to submit application
app.post('/api/submit-application', async (req, res) => {
    try {
        const application = new Application(req.body);
        await application.save();
        res.status(201).json({ message: 'Application submitted successfully', application });
    } catch (error) {
        res.status(400).json({ message: 'Error submitting application', error: error.message });
    }
});

// GET endpoint to retrieve all applications
app.get('/api/applications', async (req, res) => {
    try {
        const applications = await Application.find().sort({ createdAt: -1 });
        res.json(applications);
    } catch (error) {
        res.status(500).json({ message: 'Error retrieving applications', error: error.message });
    }
});

const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
