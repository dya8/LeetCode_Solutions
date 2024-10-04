class Solution
 {
    public long dividePlayers(int[] skill)
     {
        Arrays.sort(skill); // Sort the skills in ascending order
        int n = skill.length;
        int totalSkill = skill[0] + skill[n - 1]; // The expected total skill for each team
        long sumChemistry = 0l;

        // Create teams of two players with equal total skill
        for (int i = 0; i < n / 2; i++)
         {
            int teamSkill = skill[i] + skill[n - 1 - i];
            if (teamSkill != totalSkill) 
            {
                return -1; // If a team cannot have the expected total skill
            }
            sumChemistry += skill[i] * skill[n - 1 - i]; // Add the chemistry of the current team
        }
        return sumChemistry;
}
 }