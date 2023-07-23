import  { useState } from 'react';

const ScriptForm = ({ onSubmit }) => {
  const [script, setScript] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(script);
  };

  return (
    <form onSubmit={handleSubmit}>
      <textarea
        value={script}
        onChange={(e) => setScript(e.target.value)}
        placeholder="Enter your script here..."
        rows={6}
        cols={50}
      />
      <button style={{backgroundColor:"orange"}} type="submit">Execute Script</button>
    </form>
  );
};

export default ScriptForm;
