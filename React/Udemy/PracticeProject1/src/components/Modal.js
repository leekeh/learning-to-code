import "./Modal.css";

const Modal = (props) => {
  if (props.content !== "") {
    console.log("modal will be rendered");
    return (
      <div>
        <div className="Overlay"></div>
        <div className="Modal">
          <h1>Invalid input</h1>
          <p>{props.content}</p>
          <button
            className="Button"
            onClick={props.onClick}
            style={{ float: "right" }}
          >
            Ok
          </button>
        </div>
      </div>
    );
  }
  return null;
};

export default Modal;
