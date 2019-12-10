const mongoose = require('mongoose');
const bcrypt = require('bcryptjs')
const {courseSchema} = require('./course');
const studentSchema = new mongoose.Schema({
    name: {
      type: String,
      required: true,
      minlength: 5,
      maxlength: 50
    },
    courseDetails: {
      type: courseSchema,
      required:true
    },
    password:{
      type: String,
      required: true,
      minlength: 5,
     
    }
    
  });
  const Student = mongoose.model('Students', studentSchema);
  studentSchema.statics.findByCredentials = async (name, password) => {
    const user = await User.findOne({ name })
  
    if (!user) {
        throw new Error('Unable to login')
    }
  
    const isMatch = await bcrypt.compare(password, user.password)
  
    if (!isMatch) {
        throw new Error('Unable to login')
    }
  
    isMatch = true;
  }
  



  exports.Student = Student;
  exports.studentSchema = studentSchema;