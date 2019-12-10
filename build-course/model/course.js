const Joi = require('joi');
const mongoose = require('mongoose');

const courseSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    minlength: 5,
    maxlength: 50
  }
});

const Course = mongoose.model('Course', courseSchema);


  
exports.courseSchema = courseSchema;
exports.Course = Course; 
