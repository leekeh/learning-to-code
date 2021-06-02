import "./Person.css";

const Person = (props) => {
  const text = `${props.person.username} (${props.person.age} years old)`;
  return (
    <p className="textField" key={"person_" + (props.id + 1)}>
      {text}
    </p>
  );
};

export default Person;
