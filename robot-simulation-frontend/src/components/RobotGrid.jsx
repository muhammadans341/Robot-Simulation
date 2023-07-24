import '../styles/GridCell.css';

const RobotGrid = ({ position }) => {
  const gridCells = [];

  for (let row = 0; row < 5; row++) {
    for (let col = 0; col < 5; col++) {
      const isRobotHere = position.x === col && position.y === row;
      const cellClass = isRobotHere ? 'grid-cell robot' : 'grid-cell';
      gridCells.push(
        <div key={`${col}-${row}`} className={cellClass}>
          {isRobotHere ? <img 
          src="./robot.png" 
          alt="Robot" 
          className={`robot-img direction-${position.direction.toLowerCase()}`}
          style={{ width: '50px', height: '50px' }} /> :''}
        </div>
      );
    }
  }

  return (
    <div className="grid">
      {gridCells}
    </div>
  );
};

export default RobotGrid;
