import React, { useContext, useState, useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { UserContext } from "./App";

function AddCard() {
  const { cardData, setCardData } = useContext(UserContext);
  const location = useLocation();
  const navigate = useNavigate();
  const [card, setCard] = useState(
    location.state?.editCard || { image: "", title: "", quote: "" }
  );
  const index = location.state?.index;

  const insertImg = (e) => {
    const imgFile = e.target.files[0];
      const imgUrl = URL.createObjectURL(imgFile);
      setCard({ ...card, image: imgUrl });
    
  };
  const inputTitle = (e) => {
    setCard({ ...card, title: e.target.value });
  };
  const inputQuote = (e) => {
    setCard({ ...card, quote: e.target.value });
  };

  const funCancel = () => {
    navigate("/persona");
  };

  const add = () => {
    if (!card.title || !card.quote || !card.image) {
      alert("Fill all fields");
      return;
    }

    if (index != null) {
      const tempCard = [...cardData];
      tempCard[index] = card;
      setCardData(tempCard);
    } else {
      setCardData([...cardData, card]);
    }

    navigate("/persona");
  };

  return (
    <div>
      <h1>{index != null ? "Edit Persona" : "Add Persona"}</h1>
      <input type="file" onChange={insertImg} />
      <input
        type="text"
        name="title"
        placeholder="Enter title"
        value={card.title}
        onChange={inputTitle}
      />
      <input
        type="text"
        name="quote"
        placeholder="Enter quote"
        value={card.quote}
        onChange={inputQuote}
      />
      <button onClick={add}>{index != null ? "Update" : "Add"}</button>
      <button onClick={funCancel}>Cancel</button>
    </div>
  );
}

export default AddCard;
