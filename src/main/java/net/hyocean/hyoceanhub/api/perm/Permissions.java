package net.hyocean.hyoceanhub.api.perm;

public enum Permissions {

    GameModeUSE("hyocean.gamemode.use"),
    GameModeCREATIVE("hyocean.gamemode.creative"),
    GameModeSURVIVAL("hyocean.gamemode.survival"),
    GameModeSPECTATOR("hyocean.gamemode.spectator"),
    GameModeADVENTURE("hyocean.gamemode.adventure"),
    GameModeSTRANGE("hyocean.gamemode.strange");

    private final String permissions;

    Permissions(String perms){
        permissions = perms;
    }

    public String getPerms(){
        return permissions;
    }

}
