// import React, { useContext, useState, useEffect } from "react";
// import { useLocation, useNavigate } from "react-router-dom";
// import { UserContext } from "./App";
// import { toast } from "react-toastify";

// function AddCard() {
//   const { cardData, setCardData } = useContext(UserContext);
//   const location = useLocation();
//   const navigate = useNavigate();
//   const [card, setCard] = useState(
//     location.state?.editCard || { image: "", title: "", quote: "" }
//   );
//   const index = location.state?.index;

//   const insertImg = (e) => {
//     const imgFile = e.target.files[0];
//       const imgUrl = URL.createObjectURL(imgFile);
//       setCard({ ...card, image: imgUrl });
    
//   };
//   const inputTitle = (e) => {
//     setCard({ ...card, title: e.target.value });
//   };
//   const inputQuote = (e) => {
//     setCard({ ...card, quote: e.target.value });
//   };

//   const funCancel = () => {
//     navigate("/persona");
//   };

//   const add = () => {
//     if (!card.title || !card.quote || !card.image) {
//       toast.error("Fill all fields")
//       return;
//     }

//     if (index != null) {
//       const tempCard = [...cardData];
//       tempCard[index] = card;
//       setCardData(tempCard);
//     } else {
//       setCardData([...cardData, card]);
//     }

//     navigate("/persona");
//   };

//   return (
//     <div>
//       <h1>{index != null ? "Edit Persona" : "Add Persona"}</h1>
//       <input type="file" onChange={insertImg} />
//       <input
//         type="text"
//         name="title"
//         placeholder="Enter title"
//         value={card.title}
//         onChange={inputTitle}
//       />
//       <input
//         type="text"
//         name="quote"
//         placeholder="Enter quote"
//         value={card.quote}
//         onChange={inputQuote}
//       />
//       <button onClick={add}>{index != null ? "Update" : "Add"}</button>
//       <button onClick={funCancel}>Cancel</button>
//     </div>
//   );
// }

// export default AddCard;

import React, { useContext } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import { UserContext } from "./App";
import { toast } from "react-toastify";
import './AddCard.css'

function AddCard() {
  const { cardData, setCardData } = useContext(UserContext);
  const location = useLocation();
  const navigate = useNavigate();

  const {
    register,
    handleSubmit,
    setValue,
    watch,
    formState: { errors },
  } = useForm({
    defaultValues: location.state?.editCard || { image: "", title: "", quote: "" },
  });

  const index = location.state?.index;

  const onSubmit = (data) => {
    const { title, quote, image } = data;

    if (!title && !quote && !image) {
      toast.error("Fill at least one field");
      return;
    }

    if (index != null) {
      const tempCard = [...cardData];
      tempCard[index] = data;
      setCardData(tempCard);
    } else {
      setCardData([...cardData, data]);
    }

    navigate("/persona");
  };

  const handleImageUpload = (e) => {
    const imgFile = e.target.files[0];
    if (imgFile) {
      if (!imgFile.type.startsWith("image/")) {
        toast.error("Upload an image file");
        return;
      }

      if (imgFile.size > 5 * 1024 * 1024) {
        toast.error("Upload a file less than 5MB");
        return;
      }

      const imgUrl = URL.createObjectURL(imgFile);
      setValue("image", imgUrl, { shouldValidate: true });
    }
  };

  const handleCancel = () => {
    navigate("/persona");
  };

  const imagePreview = watch("image") || "https://via.placeholder.com/150"; // Default image

  return (
    <div className="body">
      <h1 className="heading">{index != null ? "Edit Persona" : "Add Persona"}</h1>
      <form className="form-container" onSubmit={handleSubmit(onSubmit)}>
        <div className="form-group">
          <label className="label">Image:</label>
          <input
            type="file"
            className="input-file"
            onChange={handleImageUpload}
          />
          <img src={imagePreview} alt="Preview" className="image-preview" />
        </div>

        <div className="form-group">
          <label className="label">Title:</label>
          <input
            type="text"
            className="input-text"
            {...register("title")}
            placeholder="Enter title"
          />
        </div>

        <div className="form-group">
          <label className="label">Quote:</label>
          <input
            type="text"
            className="input-text"
            {...register("quote")}
            placeholder="Enter quote"
          />
        </div>

        <button type="submit" className="button">
          {index != null ? "Update" : "Add"}
        </button>
        <button type="button" className="button button-cancel" onClick={handleCancel}>
          Cancel
        </button>
      </form>
    </div>
  );
}

export default AddCard;
