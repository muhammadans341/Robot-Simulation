import { useState } from 'react';
import './App.css';
import axios from 'axios';
import ScriptForm from './components/ScriptForm';
import RobotGrid from './components/RobotGrid';

const App = () => {
  const [robotPosition, setRobotPosition] = useState({ x: 0, y: 0, direction: 'EAST' });

  const executeScript = (positionData) => {
    return new Promise((resolve) => {
      setTimeout(() => {
        let position = { ...robotPosition };
        const {coordinateX, coordinateY, direction} = positionData;
        position = { x: parseInt(coordinateX), y: parseInt(coordinateY), direction };
        setRobotPosition(position);
        resolve(position);
      }, 1000);
    });
  };

  const handleScriptSubmit = async (script) => {
    try {
      const response = await axios.post('http://localhost:8080/api/v1/robot/simulate', script, {
        headers: {
          'Content-Type': 'text/plain',
        },
      });
      executeScript(response.data).then((updatedPosition) => {
        console.log('Robot position updated:', updatedPosition);
      });
    } catch (error) {
      console.error('Error during simulation:', error);
    }
  };

  return (
    <div className="App">
      <h1>Robot Control</h1>
      <ScriptForm onSubmit={handleScriptSubmit} />
      <RobotGrid position={robotPosition} />
    </div>
  );
};

export default App;
