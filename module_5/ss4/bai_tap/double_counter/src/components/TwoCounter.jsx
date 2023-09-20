import React, {useState} from 'react';

function TwoCounter() {
  let [countOne,setCountOne] = useState(0);
  const click = () => {
    const clickOne = countOne + 1;
    setCountOne(clickOne);
  }
    let [countTwo,setCountTwo] = useState(0);
    const clicker = () => {
    const clickTwo = countTwo +2;
    setCountTwo(clickTwo)
  }
  return(
    <>
        <div>
            Giá Trị {countOne}
            Giá Trị {countTwo}
            <div>
                <button onClick={click}>Add1</button>
                <button onClick={clicker}>Add2</button>
            </div>
        </div>
    </>
  )
}



export default TwoCounter;