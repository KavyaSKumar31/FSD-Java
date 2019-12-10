const Joi = require('joi');
const mongoose = require('mongoose');
const express = require('express');
const router = express.Router();

const Course = require('../model/course').Course;
  
router.get('/', async (req, res) => {
  const course = await course.find().sort('name');
  res.send(course);
});

router.post('/', async (req, res) => {
  

  let course= new Course({ 
    name: req.body.name,
    
  });
  course = await course.save();
  
  res.send(course);
});

router.put('/:id', async (req, res) => {
  

  const course = await Course.findByIdAndUpdate(req.params.id,
    { 
      name: req.body.name,
      
    }, { new: true });

  if (!course) return res.status(404).send('The course with the given ID was not found.');
  
  res.send(course);
});

router.delete('/:id', async (req, res) => {
  const course = await course.findByIdAndRemove(req.params.id);

  if (!course) return res.status(404).send('The course with the given ID was not found.');

  res.send(course);
});

router.get('/:id', async (req, res) => {
  const course = await course.findById(req.params.id);

  if (!course) return res.status(404).send('The course with the given ID was not found.');

  res.send(course);
});



module.exports = router; 