# Write your MySQL query statement below
WITH first_login AS (
    SELECT 
        player_id, 
        MIN(event_date) AS first_login_date
    FROM Activity
    GROUP BY player_id
)

SELECT 
    ROUND(
        1.0 * COUNT(DISTINCT a.player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 2
    ) AS fraction
FROM Activity a
JOIN first_login f ON a.player_id = f.player_id
WHERE a.event_date = DATE_ADD(f.first_login_date, INTERVAL 1 DAY);
