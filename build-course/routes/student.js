const Joi = require('joi');
const mongoose = require('mongoose');
const express = require('express');
const router = express.Router();
const bcrypt = require('bcryptjs')
const {Course} = require('../model/course');
const Student = require('../model/student').Student;

let isMatch=false;
router.post('/login',async(req,res)=>{
  console.log('loggin in');
  let name = req.body.name;
  try{
  const user = await Student.findOne({ name })
  
  if (!user) {
      throw new Error('Unable to login')
  }

  const Match = await bcrypt.compare(req.body.password, user.password)

  if (!Match) {
      throw new Error('Unable to login')
  }

  isMatch = true;
  res.status(200).send();
}
catch(e){
  console.log(e);
}
    
  
})


router.get('/', async (req, res) => {
  if(isMatch){
  const student = await Student.find().sort('name');
  res.send(student);
  }else{
    res.send('Login First');
  }
});

router.post('/', async (req, res) => {
  
    console.log(req.body.courseId);
    const course = await Course.findById(req.body.courseId);
    console.log(course);
    if (!course) return res.status(400).send('Invalid Course.');
    let password = await bcrypt.hash(req.body.password, 8)
  let student= new Student({ 
    name: req.body.name,
    courseDetails: {
      _id: course._id,
      name: course.name
    },
    password: password,

    
  });
  student = await student.save();
  
  res.send(student);
 
});

router.put('/:id', async (req, res) => {
 
  if(isMatch){
  const student = await Student.findByIdAndUpdate(req.params.id,
    { 
      name: req.body.name,
      courseDetails: req.body.courseDetails
      
    }, { new: true });

  if (!student) return res.status(404).send('The student with the given ID was not found.');
  
  res.send(student);
  }else{
    res.send('Login First');
  }
});

router.delete('/:id', async (req, res) => {
  if(isMatch){
  const student = await student.findByIdAndRemove(req.params.id);

  if (!student) return res.status(404).send('The student with the given ID was not found.');

  res.send(student);}else{
    res.send('Login First');
  }
});

router.get('/:id', async (req, res) => {
  if(isMatch){
  const student = await student.findById(req.params.id);

  if (!student) return res.status(404).send('The student with the given ID was not found.');

  res.send(student);
  }else{
    res.send('Login First');
  }
});


module.exports = router; 