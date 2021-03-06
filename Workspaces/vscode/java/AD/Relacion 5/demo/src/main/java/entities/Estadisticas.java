package entities;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Generated 16-feb-2022 12:32:36 by Hibernate Tools 4.3.1



/**
 * Estadisticas generated by hbm2java
 */
@Entity
@Table(name="estadisticas"
    ,catalog="nba"
)
public class Estadisticas  implements java.io.Serializable {


     private EstadisticasId id;
     private Jugadores jugadores;
     private Float puntosPorPartido;
     private Float asisPorPartido;
     private Float taponesPorPartido;
     private Float rebotesPorPartido;

    public Estadisticas() {
    }

	
    public Estadisticas(EstadisticasId id, Jugadores jugadores) {
        this.id = id;
        this.jugadores = jugadores;
    }
    public Estadisticas(EstadisticasId id, Jugadores jugadores, Float puntosPorPartido, Float asisPorPartido, Float taponesPorPartido, Float rebotesPorPartido) {
       this.id = id;
       this.jugadores = jugadores;
       this.puntosPorPartido = puntosPorPartido;
       this.asisPorPartido = asisPorPartido;
       this.taponesPorPartido = taponesPorPartido;
       this.rebotesPorPartido = rebotesPorPartido;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="temporada", column=@Column(name="temporada", nullable=false, length=5) ), 
        @AttributeOverride(name="jugador", column=@Column(name="jugador", nullable=false) ) } )
    public EstadisticasId getId() {
        return this.id;
    }
    
    public void setId(EstadisticasId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="jugador", nullable=false, insertable=false, updatable=false)
    public Jugadores getJugadores() {
        return this.jugadores;
    }
    
    public void setJugadores(Jugadores jugadores) {
        this.jugadores = jugadores;
    }

    
    @Column(name="puntos_por_partido", precision=5)
    public Float getPuntosPorPartido() {
        return this.puntosPorPartido;
    }
    
    public void setPuntosPorPartido(Float puntosPorPartido) {
        this.puntosPorPartido = puntosPorPartido;
    }

    
    @Column(name="asis_por_partido", precision=5)
    public Float getAsisPorPartido() {
        return this.asisPorPartido;
    }
    
    public void setAsisPorPartido(Float asisPorPartido) {
        this.asisPorPartido = asisPorPartido;
    }

    
    @Column(name="tapones_por_partido", precision=5)
    public Float getTaponesPorPartido() {
        return this.taponesPorPartido;
    }
    
    public void setTaponesPorPartido(Float taponesPorPartido) {
        this.taponesPorPartido = taponesPorPartido;
    }

    
    @Column(name="rebotes_por_partido", precision=5)
    public Float getRebotesPorPartido() {
        return this.rebotesPorPartido;
    }
    
    public void setRebotesPorPartido(Float rebotesPorPartido) {
        this.rebotesPorPartido = rebotesPorPartido;
    }




}


