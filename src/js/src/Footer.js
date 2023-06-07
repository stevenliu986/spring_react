import React from "react";
import {Avatar, Button} from "antd";
import "./Footer.css";

const Footer = ({openModal, numberOfStudents}) => (
        <div className="footer">
            {numberOfStudents !== undefined ? (
                    <Avatar
                            style={{backgroundColor: "#f56a00", marginRight: "5px"}}
                            size="large"
                    >
                        {numberOfStudents}
                    </Avatar>
            ) : null}
            <Button type="primary" onClick={openModal}>Add new student +</Button>
        </div>
);
export default Footer;