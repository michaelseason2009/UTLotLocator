package jsm.utlotlocater;

/**
 * Created by Jimny on 5/3/2016.
 */
//entry for listlotsActivity
public class LotListEntry {
    private String lotName;

    private LotListEntry() {
    }

    LotListEntry(String lotName) {
        this.lotName = lotName;

    }

    public String getLotName() {
        return lotName;
    }
}


