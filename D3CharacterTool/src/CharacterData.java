public class CharacterData {
	String[] CharacterDataStringArray = new String[28];
	double DamageIncreasedbyStrenght; //Percentage and two Decimal
	double DamageIncreasebySkills; //Percentage and two Decimal
	double AttacksperSecond; // Two Decimal
	double CriticalHitChance; //Percentage and two Decimal
	double CriticalHitDamage; //Percentage and two Decimal
	
	//Defense Stats
	String[] blockArray = new String[1]; //Array used to split Block Amount
	double BlockAmountMIN; //Minimum Block Amount
	double BlockAmountMAX; //Maximum Block Amount
	double BlockChance; //Percentage and one Decimal
	double DodgeChance; //Percentage and one Decimal
	double DamageReduction; //Percentage and two Decimal
	double PhysicalResistance; //No Decimal
	double ColdResistance; //No Decimal
	double FireResistance; //No Decimal
	double LightningResistance; //No Decimal
	double PoisonResistance; //No Decimal
	double ArcaneHolyResistance; //No Decimal
	double CrowdControlReduction; //Percentage and two Decimal
	double MissleDamageReduction; //Percentage and two Decimal
	double MeleeDamageReduction; //Percentage and two Decimal
	double Thorns;
	
	//Life
	double MaximumLife; //No Decimal
	double TotalLifeBonus; //Percentage and no Decimal
	double LifeperSecond; // Two Decimal
	double LifeSteal; //Percentage and two Decimal
	double LifeperKill; // Two Decimal
	double LifeperHit; // Two Decimal
	double HealthGlobeHealingBonus; // Two Decimal
	double BonustoGoldGlobeRadius; // Two Decimal
	
	//Base Stats
	double BaseStrength;
	double BaseDexterity;
	double BaseIntelligence;
	double BaseVitality;
	double BaseArmor;
	double BaseDamage;
	double BaseLevel;
	
	//Advanced Stats
	double MonsterLevel; //Used for Mitigation Calculation.
	double PhysicalMitigation;
	double ColdMitigation; // Formula = R/((5*mL)+R)
	double FireMitigation; // Formula = R/((5*mL)+R)
	double LightningMitigation; // Formula = R/((5*mL)+R)
	double PoisonMitigation; // Formula = R/((5*mL)+R)
	double ArcaneHolyMitigation; // Formula = R/((5*mL)+R)
	
	//Details Window Data from Character Window
	public void DetailsWindow(String[] stringArray) {
		CharacterDataStringArray = stringArray;
		
		//Strip Percent and Plus Symbol for Int storage
		for(int i = 0; i < stringArray.length; i++) {
			stringArray[i] = stringArray[i].replaceAll("[\\%\\+\n]+","");
		}
		
		//Strip comma or period from stats that dont need it
		//This is kind of a bug that should be sorted out differently
		stringArray[19] = stringArray[19].replaceAll("[\\.]",""); //Max Health
		
		//Offense Stats
		DamageIncreasedbyStrenght = Double.parseDouble(stringArray[0]);
		DamageIncreasebySkills = Double.parseDouble(stringArray[1]);
		AttacksperSecond = Double.parseDouble(stringArray[2]);
		CriticalHitChance = Double.parseDouble(stringArray[3]);
		CriticalHitDamage = Double.parseDouble(stringArray[4]);
		
		//Defense Stats
		blockArray = stringArray[5].split("-"); 
		BlockAmountMIN = Double.parseDouble(blockArray[0]);
		BlockAmountMAX = Double.parseDouble(blockArray[1]);
		BlockChance = Double.parseDouble(stringArray[6]);
		DodgeChance = Double.parseDouble(stringArray[7]);
		DamageReduction = Double.parseDouble(stringArray[8]);
		PhysicalResistance = Double.parseDouble(stringArray[9]);
		ColdResistance = Double.parseDouble(stringArray[10]);
		FireResistance = Double.parseDouble(stringArray[11]);
		LightningResistance = Double.parseDouble(stringArray[12]);
		PoisonResistance = Double.parseDouble(stringArray[13]);
		ArcaneHolyResistance = Double.parseDouble(stringArray[14]);
		CrowdControlReduction = Double.parseDouble(stringArray[15]);
		MissleDamageReduction = Double.parseDouble(stringArray[16]);
		MeleeDamageReduction = Double.parseDouble(stringArray[17]);
		Thorns = Double.parseDouble(stringArray[18]);
		
		//Life
		MaximumLife = Double.parseDouble(stringArray[19]);
		TotalLifeBonus = Double.parseDouble(stringArray[20]);
		LifeperSecond = Double.parseDouble(stringArray[21]);
		LifeSteal = Double.parseDouble(stringArray[22]);
		LifeperKill = Double.parseDouble(stringArray[23]);
		LifeperHit = Double.parseDouble(stringArray[24]);
		HealthGlobeHealingBonus = Double.parseDouble(stringArray[25]);
		BonustoGoldGlobeRadius = Double.parseDouble(stringArray[26]);
		
	}
		
	//Base Stats from Character Window
	public void BaseStats(String[] stringArray) {
		
		//Base Stats
		BaseStrength = Double.parseDouble(stringArray[0]);
		BaseDexterity = Double.parseDouble(stringArray[0]);
		BaseIntelligence = Double.parseDouble(stringArray[0]);
		BaseVitality = Double.parseDouble(stringArray[0]);
		BaseArmor = Double.parseDouble(stringArray[0]);
		BaseDamage = Double.parseDouble(stringArray[0]);
		BaseLevel = Double.parseDouble(stringArray[0]);
	}
	
	//Advanced Stats
	public void FindMitigation() {
		//Set to 60 currently. Need to take in character level from capture when that is added
		MonsterLevel = 60; 
		//PhysicalMitigation = 
		ColdMitigation = ColdResistance / ((5 * MonsterLevel) + ColdResistance);
		FireMitigation = FireResistance / ((5 * MonsterLevel) + FireResistance);
		LightningMitigation = LightningResistance / ((5 * MonsterLevel) + LightningResistance);
		PoisonMitigation = PoisonResistance / ((5 * MonsterLevel) + PoisonResistance);
		ArcaneHolyMitigation = ArcaneHolyResistance / ((5 * MonsterLevel) + ArcaneHolyResistance);
	}
}
