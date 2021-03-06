package com.artiow.moex.api;

import com.artiow.moex.api.model.SecurityPaperSearchResult;
import com.artiow.moex.api.model.SecurityPaperSpecification;

import java.util.List;

public interface SecurityPaperResource {

    /**
     * Returns list of securities traded on the MOEX.
     *
     * @param query    the query by secid, name, isin, emitentTitle, regnumber;
     * @param engine   the engine name to be searched;
     * @param market   the market name to be searched;
     * @param isTraded the sign that security paper is traded on the MOEX;
     * @param start    the offset from the beginning of the list;
     * @param limit    the number of returned securities;
     * @param lang     the response language code;
     * @return the list of securities.
     * @see <a href="http://iss.moex.com/iss/reference/5">/iss/securities</a>
     */
    List<SecurityPaperSearchResult> search(
            String query,
            String engine,
            String market,
            Boolean isTraded,
            Integer start,
            Integer limit,
            String lang
    );

    /**
     * Returns security paper specification: description and boards traded on the MOEX.
     *
     * @param secid the security paper identifier;
     * @param lang  the response language code;
     * @return the security paper specification.
     * @see <a href="http://iss.moex.com/iss/reference/13">/iss/securities/[security]</a>
     */
    SecurityPaperSpecification getSpecification(
            String secid,
            String lang
    );
}
