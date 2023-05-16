import { useEffect, useState } from "react";
import { getAllStudents } from "./client";
import { Table } from "antd";

function App() {
  const [students, setStudents] = useState([]);
  useEffect(() => {
    getAllStudents().then((res) => res.json().then((s) => setStudents(s)));
  }, []);

  if (!students) {
    return <h1>Page is loading. Please wait!</h1>;
  }

  if (students && students.length) {
    const columns = [
      { title: "Student Id", dataIndex: "studentId", key: "studentId" },
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
      <Table
        dataSource={students}
        columns={columns}
        rowKey="studentId"
        pagination={false}
      />
    );
  }

  // 如果没有取到数据，则显示下面的文字
  return <h1>No Students Found!</h1>;
}

export default App;
