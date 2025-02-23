import React, { useContext } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import { UserContext } from "./App";
import { toast } from "react-toastify";
import { MdDelete } from "react-icons/md";
import IMG from './assets/download.png'
import "./AddCard.css";

function AddCard() {
  const { cardData, setCardData } = useContext(UserContext);
  const location = useLocation();
  const navigate = useNavigate();

  const {
    register,
    handleSubmit,
    setValue,
    watch,
  } = useForm({
    defaultValues: location.state?.editCard || {
      image: "",
      title: "",
      quote: "",
    },
  });

  const index = location.state?.index;

  const onSubmit = (data) => {
    const { title, quote, image } = data;

    if (!title && !quote && !image) {
      toast.error("Fill atleast one field");
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

  const insertImg = (e) => {
    const imgFile = e.target.files[0];
    if (imgFile) {
      if (!imgFile.type.startsWith("image/")) {
        toast.error("Upload an image file");
        return;
      }

      if (imgFile.size > 5 * 1024 * 1024) {
        toast.error("Upload less than 5MB");
        return;
      }

      const imgUrl = URL.createObjectURL(imgFile);
      setValue("image", imgUrl, { shouldValidate: true });
    }
  };

  const funCancel = () => {
    navigate("/persona");
  };
  const deleteImg = ()=>{

  }
  const imagePreview = watch("image") ;
  return (
    <div className="parent-con">
      <div className="inner-con">
        <h1 className="heading">
          {index != null ? "Edit Persona" : "Add Persona"}
        </h1>
        <form className="form-con" onSubmit={handleSubmit(onSubmit)}>
          <div className="form-group img-con">
            <label className="label" htmlFor="img">Choose Image</label>
            <input type="file" id="img" className="input-file" onChange={insertImg} />
            <img src={imagePreview || IMG} alt="Preview" className="img-preview" />
            <span className="deleteIcon" onClick={deleteImg}><MdDelete /></span>
          </div>

          <div className="form-group">
            <label className="label">Title</label>
            <input
              type="text"
              className="input-text"
              {...register("title")}
              placeholder="Enter title"
            />
          </div>

          <div className="form-group">
            <label className="label">Quote</label>
            <input
              type="text"
              className="input-text"
              {...register("quote")}
              placeholder="Enter quote"
            />
          </div>
          <div className="btn-con">
          <button type="submit" className="btn">
            {index != null ? "Update" : "Add"}
          </button>
          <button
            type="button"
            className="btn button-cancel"
            onClick={funCancel}
          >
            Cancel
          </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default AddCard;
