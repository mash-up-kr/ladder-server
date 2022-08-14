package kr.mashup.ladder.playlist.dto

import kr.mashup.ladder.domain.playlist.domain.Playlist

data class PlaylistDto(
    val id: Long,
    val roomId: Long,
    val playlistItems: List<PlaylistItemDto>,
    val order: List<Long>,
) {
    companion object {
        fun of(playlist: Playlist): PlaylistDto {
            return PlaylistDto(
                id = playlist.id,
                roomId = playlist.roomId,
                playlistItems = playlist.getAcceptedItems().map { PlaylistItemDto.of(it) },
                order = playlist.order,
            )
        }
    }
}
