import { TouchableOpacity, TouchableOpacityProps, ImageBackground, ImageSourcePropType, Text } from 'react-native'

import { LinearGradient } from 'expo-linear-gradient'

import { styles } from './styles'
import { THEME } from '../../theme'

export interface GameCardProps {
  id: number,
  title: string,
  bannerUrl: string,
  advertisements: number,
}

interface Props extends TouchableOpacityProps {
  data: GameCardProps
}

export function GameCard({data, ...rest}: Props) {
  return (
    <TouchableOpacity style={styles.container} {...rest}>
      <ImageBackground
        source={{uri: data.bannerUrl}}
        style={styles.cover}
      >

        <LinearGradient
          colors={THEME.COLORS.FOOTER}
          style={styles.footer}
        >
          <Text style={styles.name}>
            {data.title}
          </Text>

          <Text style={styles.ads}>
            {data.advertisements} {data.advertisements > 1 ? 'anúncios' : 'anúncio'}
          </Text>

        </LinearGradient>
      </ImageBackground>
    </TouchableOpacity>
  )
}