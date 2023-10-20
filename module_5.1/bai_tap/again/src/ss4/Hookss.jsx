import {useState} from "react";

export function Greetings() {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");

    const handleFirstNameChange = (even) => {
        setFirstName(even.target.value);
    };
    const handleLastNameChange = (even) => {
        setLastName(even.target.value);
    };

    return (
        <>
            <p>First Name</p>
            <input
                value={firstName}
                onChange={(even) => handleFirstNameChange(even)}
            />
            <br/>
            <input
            value={lastName}
            onChange={(even)=>handleLastNameChange(even)}
            />
            <p>
                Hello, {' '}
                <span>
                    {firstName} {lastName}
                </span>
            </p>
        </>
    )
}