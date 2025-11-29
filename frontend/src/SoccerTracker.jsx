import React, { useState, useEffect } from 'react';
import './SoccerTracker.css';

const SoccerTracker = () => {
  const [monthlyCount, setMonthlyCount] = useState(0);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchGameCount();
  }, []);

  const fetchGameCount = async () => {
    try {
      const apiUrl = import.meta.env.VITE_API_URL || '';
      const response = await fetch(`${apiUrl}/api/games/count`);
      const data = await response.json();
      setMonthlyCount(data.monthly || 0);
      setLoading(false);
    } catch (error) {
      console.error('Error fetching game count:', error);
      setLoading(false);
    }
  };

  const handleIncrement = async () => {
    if (monthlyCount < 9) {
      try {
        const apiUrl = import.meta.env.VITE_API_URL || '';
        const response = await fetch(`${apiUrl}/api/games/increment`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
        });
        const data = await response.json();
        setMonthlyCount(data.monthly || 0);
      } catch (error) {
        console.error('Error incrementing count:', error);
      }
    }
  };

  const handleDecrement = async () => {
    if (monthlyCount > 0) {
      try {
        const apiUrl = import.meta.env.VITE_API_URL || '';
        const response = await fetch(`${apiUrl}/api/games/decrement`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
        });
        const data = await response.json();
        setMonthlyCount(data.monthly || 0);
      } catch (error) {
        console.error('Error decrementing count:', error);
      }
    }
  };

  return (
    <div className="tracker-container">
      <div className="image-container">
        <div className="stats-card">
          <div className="monthly-label">monthly games watched:</div>
          
          <div className="month-selector">
            <div className="arrow-left" onClick={handleDecrement}>
              <svg width="11" height="11" viewBox="0 0 11 11" fill="none">
                <path d="M7 2L3 5.5L7 9" stroke="#797979" strokeWidth="1"/>
              </svg>
            </div>
            <div className="monthly-count">{loading ? '...' : monthlyCount}</div>
            <div className="arrow-right" onClick={handleIncrement}>
              <svg width="11" height="11" viewBox="0 0 11 11" fill="none">
                <path d="M4 2L8 5.5L4 9" stroke="#797979" strokeWidth="1"/>
              </svg>
            </div>
          </div>
        </div>

        <div className="chart-container">
          {[...Array(9)].map((_, index) => (
            <div
              key={index}
              className={`chart-bar ${index < monthlyCount ? 'filled' : 'empty'}`}
            ></div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default SoccerTracker;
