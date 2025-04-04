import React, { useState,useEffect} from 'react';
import './App.css'

export default function App() {
  let [username, setUsername] = useState('');
  let [password, setPassword] = useState('');
  let [page, setPage] = useState(true);
  const [userId, setUserId] = useState(null);
  const [user, setUser] = useState(null);
  const [users, setUsers] = useState([]); 

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await fetch("http://localhost:8081/user");

        if (!response.ok) {
          throw new Error("Failed to fetch users");
        }
        const data = await response.json();
        setUsers(data); 
      } catch (error) {
        console.error("Error fetching user data:", error);
      }
    };

    fetchUsers();
  }, []); 

  function log(username, password) {
    const userFound = users.find((u) => u.username === username && u.password === password);

    if (userFound) {
      setPage(false); 
      setUserId(userFound.id);
      setUsername('');
      setPassword('');
      setUser(userFound.username);
    } else {
      alert('Invalid credentials');
    }
  }

  return (
    <>
      {
        page ? (
          <div id="login-form">
            <h1>Login</h1>
            <form onSubmit={(e) => {
              e.preventDefault(); 
              log(username, password);
            }}>
              <label htmlFor="username">Username:</label>
              <input 
                type="text" 
                id="username" 
                name="username" 
                value={username} 
                onChange={(e) => setUsername(e.target.value)} 
              />
              <label htmlFor="password">Password:</label>
              <input 
                type="password" 
                id="password" 
                name="password" 
                value={password} 
                onChange={(e) => setPassword(e.target.value)} 
              />
              <input type="submit" value="Submit" />
            </form>
          </div>
        ) : (
          <Home id={userId} user={user} />
        )
      }
    </>
  );
}


function Home({ id, user }) {
  let [sbool, setsbool] = useState(false);
  let [ibool, setibool] = useState(false);
  let [cbool, setcbool] = useState(false);

  return (
    
    <div className="Home">
      <h2>Welcome {user}</h2>
      <div className="button-container">
        <button className="action-button" onClick={() => setibool(!ibool)}>
          Inbox
        </button>
        {ibool && <Inbox id={id} />}
      </div>

      <div className="button-container">
        <button className="action-button" onClick={() => setsbool(!sbool)}>
          Sent
        </button>
        {sbool && <Sent />}
      </div>

      <div className="button-container">
        <button className="action-button" onClick={() => setcbool(!cbool)}>
          Compose
        </button>
        {cbool && <Compose id={id} user={user} />}
      </div>
    </div>
  );
}

function Inbox({ id }) {
  const [data, setData] = useState([]);

  useEffect(() => {
    getData();
  }, []);

  async function getData() {
    try {
      let res = await fetch("http://localhost:8081/inbox");
      if (!res.ok) throw new Error('Network response was not ok');
      let newData = await res.json();
      setData(newData);
    } catch (error) {
      console.error("Error fetching data:", error);
      alert("Error fetching data: " + error.message);
    }
  }

  return (
    <div className="container">
      <h2>Inbox</h2>
      <table>
        <thead>
          <tr>
            <th>Sender</th>
            <th>Receiver</th>
            <th>Subject</th>
            <th>Body</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item, index) => (
            <tr key={index}>
              <td>{item.sender}</td>
              <td>{item.receiver}</td>
              <td>{item.subject}</td>
              <td>{item.body}</td>
              <td>{item.date}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

function Sent() {
  const [data, setData] = useState([]);

  useEffect(() => {
    getData();
  }, []);

  async function getData() {
    try {
      let res = await fetch("http://localhost:8081/sent");
      if (!res.ok) throw new Error('Network response was not ok');
      let newData = await res.json();
      setData(newData);
    } catch (error) {
      console.error("Error fetching data:", error);
      alert("Error fetching data: " + error.message);
    }
  }

  return (
    <div className="container">
      <h2>Sent Messages</h2>
      <table>
        <thead>
          <tr>
            <th>To</th>
            <th>Title</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item, index) => (
            <tr key={index}>
              <td>{item.receiver}</td>
              <td>{item.subject}</td>
              <td>{item.date}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

function Compose({ id, user }) {
  const [recipient, setRecipient] = useState('');
  const [subject, setSubject] = useState('');
  const [body, setBody] = useState('');
  const [sender, setSender] = useState(user);
  const [date] = useState('2025-04-03T03:30:00.000+00:00');
  const [sentId, setsentId] = useState(6);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const emailData = {
      body: body || 'This is the sent message body.',
      date: date,
      userid: id || 1,
      id: sentId,
      receiver: recipient,
      sender: sender,
      subject: subject || 'Subject',
    };
    setsentId(sentId + 1);

    try {
      const response = await fetch('http://localhost:8081/sent', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(emailData),
      });

      if (response.ok) {
        console.log('Email sent successfully');
      } else {
        console.log('Failed to send email:', response.statusText);
      }
    } catch (error) {
      console.error('Error sending email:', error);
    }
  };

  return (
    <div className="container">
      <h2>Compose Email</h2>
      <form onSubmit={handleSubmit}>
        <label htmlFor="recipient">To:</label>
        <input
          type="text"
          id="recipient"
          placeholder="Recipient"
          value={recipient}
          onChange={(e) => setRecipient(e.target.value)}
        />

        <label htmlFor="subject">Subject:</label>
        <input
          type="text"
          id="subject"
          placeholder="Subject"
          value={subject}
          onChange={(e) => setSubject(e.target.value)}
        />

        <label htmlFor="body">Body:</label>
        <textarea
          id="body"
          placeholder="Write your message here..."
          rows="6"
          value={body}
          onChange={(e) => setBody(e.target.value)}
        ></textarea>

        <button type="submit">Send</button>
      </form>
    </div>
  );
}
