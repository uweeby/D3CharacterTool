public class PrintCharacter {
	//Debug class to print all character Data to the console
	String[] textAreaArray = new String[33];
	
	public String[] setArray(CharacterData characterdata) {
		
		//Temp setup to save all data in a string array to be put into the GUI TextArea
		//Really need to clean this part up. bad.
		textAreaArray[0] = "Damage Increased by Strenght: " + characterdata.DamageIncreasedbyStrenght + "\n";
		textAreaArray[1] = "Damage Increaseby Skills: " + characterdata.DamageIncreasebySkills + "\n";
		textAreaArray[2] = "Attacks per Second: " + characterdata.AttacksperSecond + "\n";
		textAreaArray[3] = "Critical Hit Chance: " + characterdata.CriticalHitChance + "\n";
		textAreaArray[4] = "Critical Hit Damage: " + characterdata.CriticalHitDamage + "\n";
		
		textAreaArray[5] = "Block Amount MIN: " + characterdata.BlockAmountMIN + "\n";
		textAreaArray[6] = "Block Amount MAX: " + characterdata.BlockAmountMAX + "\n";
		textAreaArray[7] = "Block Chance: " + characterdata.BlockChance + "\n";
		textAreaArray[8] = "Dodge Chance: " + characterdata.DodgeChance + "\n";
		textAreaArray[9] = "Damage Reduction: " + characterdata.DamageReduction + "\n";
		textAreaArray[10] = "Physical Resistance: " + characterdata.PhysicalResistance + "\n";
		textAreaArray[11] = "Cold Resistance: " + characterdata.ColdResistance + "\n";
		textAreaArray[12] = "Fire Resistance: " + characterdata.FireResistance + "\n";
		textAreaArray[13] = "Lightning Resistance: " + characterdata.LightningResistance + "\n";
		textAreaArray[14] = "Poison Resistance: " + characterdata.PoisonResistance + "\n";
		textAreaArray[15] = "Arcane Holy Resistance: " + characterdata.ArcaneHolyResistance + "\n";
		textAreaArray[16] = "Crowd Control Reduction: " + characterdata.CrowdControlReduction + "\n";
		textAreaArray[17] = "Missle Damage Reduction: " + characterdata.MissleDamageReduction + "\n";
		textAreaArray[18] = "Melee Damage Reduction: " + characterdata.MeleeDamageReduction + "\n";
		textAreaArray[19] = "Thorns: " + characterdata.Thorns + "\n";
		
		textAreaArray[20] = "Maximum Life: " + characterdata.MaximumLife + "\n";
		textAreaArray[21] = "Total Life Bonus: " + characterdata.TotalLifeBonus + "\n";
		textAreaArray[22] = "Life per Second: " + characterdata.LifeperSecond + "\n";
		textAreaArray[23] = "Life Steal: " + characterdata.LifeSteal + "\n";
		textAreaArray[24] = "Life per Kill: " + characterdata.LifeperKill + "\n";
		textAreaArray[25] = "Life per Hit: " + characterdata.LifeperHit + "\n";
		textAreaArray[26] = "Health Globe Healing Bonus: " + characterdata.HealthGlobeHealingBonus + "\n";
		textAreaArray[27] = "Bonus to Gold Globe Radius: " + characterdata.BonustoGoldGlobeRadius + "\n";
		
		textAreaArray[28] = "ColdMitigation " + characterdata.ColdMitigation + "\n";
		textAreaArray[29] = "FireMitigation " + characterdata.FireMitigation + "\n";
		textAreaArray[30] = "LightningMitigation " + characterdata.LightningMitigation + "\n";
		textAreaArray[31] = "PoisonMitigation " + characterdata.PoisonMitigation + "\n";
		textAreaArray[32] = "ArcaneHolyMitigation " + characterdata.ArcaneHolyMitigation + "\n";
		
		return textAreaArray;

//		System.out.println("DamageIncreasedbyStrenght " + characterdata.DamageIncreasedbyStrenght);
//		System.out.println("DamageIncreasebySkills " + characterdata.DamageIncreasebySkills);
//		System.out.println("AttacksperSecond " + characterdata.AttacksperSecond);
//		System.out.println("CriticalHitChance " + characterdata.CriticalHitChance);
//		System.out.println("CriticalHitDamage " + characterdata.CriticalHitDamage);
//		
//		System.out.println("BlockAmountMIN " + characterdata.BlockAmountMIN);
//		System.out.println("BlockAmountMAX " + characterdata.BlockAmountMAX);
//		System.out.println("BlockChance " + characterdata.BlockChance);
//		System.out.println("DodgeChance " + characterdata.DodgeChance);
//		System.out.println("DamageReduction " + characterdata.DamageReduction);
//		System.out.println("PhysicalResistance " + characterdata.PhysicalResistance);
//		System.out.println("ColdResistance " + characterdata.ColdResistance);
//		System.out.println("FireResistance " + characterdata.FireResistance);
//		System.out.println("LightningResistance " + characterdata.LightningResistance);
//		System.out.println("PoisonResistance " + characterdata.PoisonResistance);
//		System.out.println("ArcaneHolyResistance " + characterdata.ArcaneHolyResistance);
//		System.out.println("CrowdControlReduction " + characterdata.CrowdControlReduction);
//		System.out.println("MissleDamageReduction " + characterdata.MissleDamageReduction);
//		System.out.println("MeleeDamageReduction " + characterdata.MeleeDamageReduction);
//		System.out.println("Thorns " + characterdata.Thorns);
//		
//		System.out.println("MaximumLife " + characterdata.MaximumLife);
//		System.out.println("TotalLifeBonus " + characterdata.TotalLifeBonus);
//		System.out.println("LifeperSecond " + characterdata.LifeperSecond);
//		System.out.println("LifeSteal " + characterdata.LifeSteal);
//		System.out.println("LifeperKill " + characterdata.LifeperKill);
//		System.out.println("LifeperHit " + characterdata.LifeperHit);
//		System.out.println("HealthGlobeHealingBonus " + characterdata.HealthGlobeHealingBonus);
//		System.out.println("BonustoGoldGlobeRadius " + characterdata.BonustoGoldGlobeRadius);
//
//		System.out.println("ColdMitigation " + characterdata.ColdMitigation);
//		System.out.println("FireMitigation " + characterdata.FireMitigation);
//		System.out.println("LightningMitigation " + characterdata.LightningMitigation);
//		System.out.println("PoisonMitigation " + characterdata.PoisonMitigation);
//		System.out.println("ArcaneHolyMitigation " + characterdata.ArcaneHolyMitigation);

		
	}
}
