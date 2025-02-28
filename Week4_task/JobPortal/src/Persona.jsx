import React, { useContext } from "react";
import { useNavigate } from "react-router-dom";
import { UserContext } from "./App";
import { FaPlus } from "react-icons/fa";
import IMG from "./assets/download.png";
import "./Persona.css";

function Persona() {
  const navigate = useNavigate();
  const { cardData, setCardData } = useContext(UserContext);

  const addCard = () => {
    navigate("/addcard");
  };

  const edit = (index) => {
    const editCard = cardData[index];
    navigate("/addcard", { state: { editCard, index } });
  };

  const deleteCard = (index) => {
    const updatecard = cardData.filter((_, i) => i != index);
    setCardData(updatecard);
  };

  return (
    <>
      <div className="persona-heading">
        <p>{JSON.parse(localStorage.getItem("user")).name.toUpperCase()}</p>
        <span>Persona</span>
        <button onClick={addCard} className="add-btn">
          <FaPlus /> Add Persona
        </button>
      </div>
      <div className="persona-parent-con">
        <div className="persona-con">
          <div className="persona-outer-card">
            {cardData.map((data, index) => (
              <div key={index} className="persona-card">
                <img src={data.image} alt="Persona" />
                <p>{data.title}</p>
                <p>{data.quote}</p>
                <div className="card-btn">
                  <button
                    className="edit-btn btn btn-info"
                    onClick={() => edit(index)}
                  >
                    Edit
                  </button>
                  <button
                    className="delete-btn btn bg-danger"
                    onClick={() => deleteCard(index)}
                  >
                    Delete
                  </button>
                </div>
              </div>
            ))}

            <div className="persona-card" onClick={addCard}>
              <img src={IMG} alt="defaultImage" />
              <p>Enter Title</p>
              <p>Enter Quote</p>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Persona;
