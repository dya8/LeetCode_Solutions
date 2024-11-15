# Write your MySQL query statement below
select DISTINCT user_id AS user_id,count(follower_id) as followers_count
from Followers
group by user_id
order by user_id;