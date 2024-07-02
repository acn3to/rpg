package com.skyrim.rpg.domain.enums;

public enum ItemEnum {
    DAGGER_OF_NIGHT_MOTHER(
            1,
            "Dagger of Night Mother",
            "A deadly dagger with the blessing of the Night Mother.",
            150,
            EffectEnum.AGILITY_BOOST
    ),
    STAFF_OF_MANA_REGENERATION(
            2,
            "Staff of Mana Regeneration",
            "A magical staff that regenerates mana over time.",
            200,
            EffectEnum.MANA_REGEN
    ),
    BATTLE_AXE_OF_RAGE(
            3,
            "Battle Axe of Rage",
            "An axe that fuels rage in battle.",
            180,
            EffectEnum.RAGE_BOOST
    ),
    RING_OF_DEFENSE(
            4,
            "Ring of Defense",
            "A sturdy ring that enhances defense against attacks.",
            120,
            EffectEnum.DEFENSE_BOOST
    ),
    AMULET_OF_INTELLECT(
            5,
            "Amulet of Intellect",
            "An enchanted amulet that enhances intelligence and spellcasting.",
            220,
            EffectEnum.INTELLECT_BOOST
    ),
    ELIXIR_OF_STAMINA(
            6,
            "Elixir of Stamina",
            "A potent elixir that boosts stamina, allowing for prolonged physical exertion.",
            160,
            EffectEnum.STAMINA_BOOST
    );

    private final int id;
    private final String name;
    private final String description;
    private final int value;
    private final EffectEnum effect;

    ItemEnum(int id, String name, String description, int value, EffectEnum effect) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.effect = effect;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    public EffectEnum getEffect() {
        return effect;
    }
}
