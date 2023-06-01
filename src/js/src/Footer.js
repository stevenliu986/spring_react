import React from 'react'
import {Avatar, Button} from "antd";
import "./Footer.css";

const Footer = (props) => (
        <div className="footer">
            {props.numberOfStudents ? <Avatar size="large">{props.numberOfStudents}</Avatar> : null}
            <Button type="primary">Add new student + </Button>
        </div>
);
export default Footer;