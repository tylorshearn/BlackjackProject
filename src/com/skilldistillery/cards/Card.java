package com.skilldistillery.cards;

public class Card{
  private Rank r;
  private Suit s;
  
  public Card(Rank rank, Suit suit) {
    this.r = rank;
    this.s = suit;
  }
  
  public int getValue() {
    return r.getValue();
  }

@Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((r == null) ? 0 : r.hashCode());
    result = prime * result + ((s == null) ? 0 : s.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Card other = (Card) obj;
    if (r != other.r)
      return false;
    if (s != other.s)
      return false;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(r);
    builder.append(" of ");
    builder.append(s);
    return builder.toString();
  }
  
}
