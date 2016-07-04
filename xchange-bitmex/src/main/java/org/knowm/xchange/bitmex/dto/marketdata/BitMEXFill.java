package org.knowm.xchange.bitmex.dto.marketdata;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.bitmex.dto.BitMEXResult;

/**
 * @author Panchen
 */

public class BitMEXFill extends BitMEXResult {

  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");

  private final Date fillTime;
  private final String order_id;
  private final String fill_id;
  private final String symbol;
  private final String side;
  private final BigDecimal size;
  private final BigDecimal price;

  public BitMEXFill(@JsonProperty("result") String result, @JsonProperty("error") String error,
      @JsonProperty("fillTime") String strfillTime, @JsonProperty("order_id") String order_id, @JsonProperty("fill_id") String fill_id,
      @JsonProperty("symbol") String symbol, @JsonProperty("side") String side, @JsonProperty("qty") BigDecimal size,
      @JsonProperty("price") BigDecimal price) throws ParseException {

    super(result, error);

    this.fillTime = strfillTime == null ? null : DATE_FORMAT.parse(strfillTime);
    this.order_id = order_id;
    this.fill_id = fill_id;
    this.symbol = symbol;
    this.side = side;
    this.size = size;
    this.price = price;
  }

  public String getSymbol() {
    return symbol;
  }

  public Date getFillTime() {
    return fillTime;
  }

  public String getOrderId() {
    return order_id;
  }

  public String getFillId() {
    return fill_id;
  }

  public String getSide() {
    return side;
  }

  public BigDecimal getSize() {
    return size;
  }

  public BigDecimal getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "BitMEXFill [order_id=" + order_id + ", fill_id=" + fill_id + ", fillTime=" + DATE_FORMAT.format(fillTime) + ", symbol=" + symbol
        + ", side=" + side + ", size=" + size + ", price=" + price + " ]";
  }
}
