import { useEffect, useState } from "react";
import { getAllStudents } from "./client";

function App() {
  const [students, setStudents] = useState([]);
  useEffect(() => {
    getAllStudents().then((res) => res.json().then((s) => setStudents(s)));
  }, []);

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

  if (!students) {
    return <h1>Page is loading. Please wait!</h1>;
  }

  // if (students && students.length) {
  //   return <Table dataSource={students} columns={columns} />;
  // }

  if (students && students.length) {
    return students.map((student) => {
      return (
        <div key={student.studentId}>
          <h2>{student.firstName}</h2>
          <h2>{student.lastName}</h2>
          <h2>{student.gender}</h2>
        </div>
      );
    });
  }
  return <h1>Hello World, Spring Boot & React</h1>;
}

export default App;
