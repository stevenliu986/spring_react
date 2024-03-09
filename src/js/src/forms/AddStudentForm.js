import React from 'react';
import {Formik} from "formik";
import {Button, Input, Tag} from "antd";
import {addNewStudent} from "../client";
import PropTypes from "prop-types";

const inputMargin = {marginBottom: "5px"};
const tagStyle = {backgroundColor: "#f50", color: "white", ...inputMargin};

const AddStudentForm = ({onSuccess}) => {
    return (
        <Formik
            initialValues={{firstName: '', lastName: '', email: '', gender: ''}}
            validate={values => {
                const errors = {};
                if (!values.firstName) {
                    errors.firstName = "First Name Required";
                }
                if (!values.lastName) {
                    errors.lastName = "Last Name Required";
                }
                if (!values.email) {
                    errors.email = 'Required';
                } else if (
                    !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
                ) {
                    errors.email = 'Invalid email address';
                }
                if (!values.gender) {
                    errors.gender = "Gender Required";
                } else if (!['FEMALE', 'MALE', 'female', 'male'].includes(values.gender)) {
                    errors.gender = "Gender must be (MALE, male, FEMALE, female)";
                }
                return errors;
            }}
            onSubmit={(student, {setSubmitting}) => {
                addNewStudent(student).then(() => {
                    onSuccess();
                    setSubmitting(false);
                });
            }}
        >
            {({
                  values,
                  errors,
                  touched,
                  handleChange,
                  handleBlur,
                  handleSubmit,
                  isSubmitting,
                  submitForm,
                  isValid
                  /* and other goodies */
              }) => (
                <form onSubmit={handleSubmit}>
                    <Input
                        style={inputMargin}
                        name="firstName"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.firstName}
                        placeholder="First name eg: John"
                    />
                    {errors.firstName && touched.firstName &&
                        <Tag style={tagStyle}>{errors.firstName}</Tag>}
                    <Input
                        style={inputMargin}
                        name="lastName"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.lastName}
                        placeholder="Last name eg: Smith"
                    />
                    {errors.lastName && touched.lastName &&
                        <Tag style={tagStyle}>{errors.lastName}</Tag>}
                    <Input
                        style={inputMargin}
                        type="email"
                        name="email"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.email}
                        placeholder="Email eg: example@example.com"
                    />
                    {errors.email && touched.email &&
                        <Tag style={tagStyle}>{errors.email}</Tag>}
                    <Input
                        style={inputMargin}
                        name="gender"
                        onChange={handleChange}
                        onBlur={handleBlur}
                        value={values.gender}
                        placeholder="Female or Male"
                    />
                    {errors.gender && touched.gender &&
                        <Tag style={tagStyle}>{errors.gender}</Tag>}
                    <Button onClick={() => submitForm()} type="submit"
                            disabled={isSubmitting || (touched && !isValid)}>
                        Submit
                    </Button>
                </form>
            )}
        </Formik>
    );
}

AddStudentForm.propTypes = {
    onSuccess: PropTypes.func.isRequired
}
export default AddStudentForm;