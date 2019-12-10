const mongoose = require('mongoose');
const course = require('./routes/course');
const student = require('./routes/student');
const express = require('express');
const app = express();
const bcrypt = require('bcryptjs')
mongoose.connect('mongodb://127.0.0.1:27017/course',{useUnifiedTopology: true,useNewUrlParser: true })
  .then(() => console.log('Connected to MongoDB...'))
  .catch(err => console.error('Could not connect to MongoDB...'));

app.use(express.json());
app.use('/api/course', course);
app.use('/api/student', student);

const port = process.env.PORT || 3000;
app.listen(port, () => console.log(`Listening on port ${port}...`));
