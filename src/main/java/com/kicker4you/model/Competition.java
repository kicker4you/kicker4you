package com.kicker4you.model;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;

import java.lang.Override;

import com.kicker4you.model.Game;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.OneToMany;

@Entity
public class Competition implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id = null;
   @Version
   @Column(name = "version")
   private int version = 0;

   @Column
   private String name;

   @OneToMany
   private Set<Game> Games = new HashSet<Game>();

   @Column
   private long creation_date;

   @Column
   private int status;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object that)
   {
      if (this == that)
      {
         return true;
      }
      if (that == null)
      {
         return false;
      }
      if (getClass() != that.getClass())
      {
         return false;
      }
      if (id != null)
      {
         return id.equals(((Competition) that).id);
      }
      return super.equals(that);
   }

   @Override
   public int hashCode()
   {
      if (id != null)
      {
         return id.hashCode();
      }
      return super.hashCode();
   }

   public String getName()
   {
      return this.name;
   }

   public void setName(final String name)
   {
      this.name = name;
   }

   public Set<Game> getGames()
   {
      return this.Games;
   }

   public void setGames(final Set<Game> Games)
   {
      this.Games = Games;
   }

   public long getCreation_date()
   {
      return this.creation_date;
   }

   public void setCreation_date(final long creation_date)
   {
      this.creation_date = creation_date;
   }

   public int getStatus()
   {
      return this.status;
   }

   public void setStatus(final int status)
   {
      this.status = status;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (name != null && !name.trim().isEmpty())
         result += "name: " + name;
      result += ", creation_date: " + creation_date;
      result += ", status: " + status;
      return result;
   }
}