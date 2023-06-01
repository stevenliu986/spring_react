import {Avatar, Table, Modal} from "antd";
import {useEffect, useState} from "react";
import {getAllStudents} from "./client";
import Footer from "./Footer";

function App() {
    const [students, setStudents] = useState([]);
    const [isModalOpen, setIsModalOpen] = useState(false);
    useEffect(() => {
        getAllStudents().then((res) => res.json().then((s) => setStudents(s)));
    }, []);

    // const openModalClick = () =>{
    //     alert("button has been clicked!")
    // }

    const showModal = () => {
        setIsModalOpen(true);
    }

    const handleOk = () => {
        setIsModalOpen(false);
    }
    const handleCancel = () => {
        setIsModalOpen(false);
    }

    if (students && students.length) {
        const columns = [
            {
                title: "Avatar",
                key: "avatar",
                render: (text, student) => (
                        <Avatar size="large" style={{backgroundColor: "#f56a00"}}>
                            {`${student.firstName.charAt(0).toUpperCase()}${student.lastName
                                    .charAt(0)
                                    .toUpperCase()}`}
                        </Avatar>
                ),
            },
            {title: "Student Id", dataIndex: "studentId", key: "studentId"},
            {
                title: "First Name",
                dataIndex: "firstName",
                key: "firstName",
            },
            {
                title: "Last Name",
                dataIndex: "lastName",
                key: "lastName",
            },
            {
                title: "Email",
                dataIndex: "email",
                key: "email",
            },
            {
                title: "Gender",
                dataIndex: "gender",
                key: "gender",
            },
        ];
        return (
                <>
                    <Table
                            dataSource={students}
                            columns={columns}
                            rowKey="studentId"
                            pagination={false}
                    />
                    <Modal title="Basic Modal" open={isModalOpen} onOk={handleOk} onCancel={handleCancel}/>
                    <Footer openModal={showModal} numberOfStudents={students.length}/>
                </>
        )
    }

    // 如果没有取到数据，则显示下面的文字
    return <h1>No Students Found!</h1>;
}

export default App;
